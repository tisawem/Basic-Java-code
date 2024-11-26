package biu.Firework

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.FitViewport

class Main : ApplicationAdapter() {


    lateinit var camera: OrthographicCamera
    lateinit var viewport: FitViewport
    override fun create() {
        camera = OrthographicCamera(800f, 600f)
        viewport = FitViewport(800f, 600f, camera).apply {
            apply(true)
        }
    }
    val batch by lazy {
        SpriteBatch().apply {
            projectionMatrix = camera.combined

        }
    }

    val 火箭 by lazy { Texture("1.jpg") }
    val 祝贺词 by lazy { Texture("4.jpg") }

    val 白色文字 by lazy {
        BitmapFont().apply {
            data.setScale(2f)
        }
    }
    val 红色文字 by lazy {
        BitmapFont().apply {
            data.setScale(2f)
            color = Color.RED
        }
    }

    var timer = 3f

    var 火箭图片位置纵坐标 = 0f
    var 祝贺词图片位置横坐标 = 0f

    override fun render() {
        ScreenUtils.clear(1f, 1f, 1f, 1f)
        batch.begin()
        if (timer > 0f) {
            timer -= Gdx.graphics.deltaTime
            红色文字.draw(batch, timer.toString(), 650f, 100f)
            白色文字.draw(batch, "The firecracker is about to be lifted into the air in \n seconds", 0f, 100f)
        } else 火箭升空()


        batch.end()


    }

    fun 火箭升空() {

        if (火箭图片位置纵坐标 < viewport.worldHeight - 火箭.height) {
            batch.draw(火箭, 0f, 火箭图片位置纵坐标)
            火箭图片位置纵坐标 += Gdx.graphics.deltaTime * 100
        } else {
            batch.draw(祝贺词, 祝贺词图片位置横坐标, 500f)
            batch.draw(祝贺词, 祝贺词.width.toFloat() + 祝贺词图片位置横坐标, 500f)
            if (祝贺词图片位置横坐标 > 祝贺词.width * -1f) {
                祝贺词图片位置横坐标 -= Gdx.graphics.deltaTime * 100
            } else {
                祝贺词图片位置横坐标 = 0f
            }

        }
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height,true)
    }

    override fun dispose() {
         火箭.dispose()
        祝贺词.dispose()
        白色文字.dispose()
        红色文字.dispose()
        batch.dispose()
    }
}
