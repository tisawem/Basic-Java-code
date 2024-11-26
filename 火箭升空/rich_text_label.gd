# 倒计时优化版本
extends RichTextLabel

@onready var timer: Timer = %Timer

func _ready() -> void:
	# 使用信号而不是每帧检查
	timer.timeout.connect(_on_timer_timeout)
	
func _on_timer_timeout() -> void:
	hide()
	set_process(false)
