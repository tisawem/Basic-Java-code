extends RichTextLabel
 
@onready var timer: Timer = %Timer
 
func _ready() -> void:
	timer.timeout.connect(_on_timer_timeout)
	 
 
func _process(delta: float) -> void:
	if %Timer.is_stopped()==false:
		text=str(%Timer.time_left) 
	 

func _on_timer_timeout() -> void:
	hide()
	set_process(false)
