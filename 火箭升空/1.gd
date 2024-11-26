
extends Sprite2D
signal finished
var initial_y: float
var moving := false
var speed := 100.0

var 信号已发送=false

func _ready() -> void:
	initial_y = get_viewport_rect().size.y - get_rect().size.y/2
	position.y = initial_y
	visible = false

func _process(delta: float) -> void:
	if not moving and %Timer.is_stopped():
		visible = true
		moving = true
	
	if moving:
		position.y -= delta * speed
		if position.y <= get_rect().size.y/2:
			hide()
			moving = false
			if not 信号已发送:
				emit_signal("finished")
				信号已发送=true
				set_process(false)
			
