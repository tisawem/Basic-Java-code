extends Sprite2D

var TextureWidth=get_rect().size.x
 
func _ready() -> void:
	pass 


 
func _process(delta: float) -> void:
	if visible:
		position.x-=delta*100
		if position.x<TextureWidth/2:
			position.x=TextureWidth*1.5


func _on__finished() -> void:
	visible=true
	position.x=TextureWidth*1.5
	position.y=85
