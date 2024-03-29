package dev.yeff.orbital.example.scenes

import dev.yeff.orbital.Game
import dev.yeff.orbital.ecs.GameObject
import dev.yeff.orbital.ecs.builders.GameObjectBuilder
import dev.yeff.orbital.example.components.ColorChanger
import dev.yeff.orbital.graphics.Color
import dev.yeff.orbital.graphics.Shapes
import dev.yeff.orbital.math.Vector2f
import dev.yeff.orbital.scenes.Scene
import dev.yeff.orbital.util.Log
import dev.yeff.orbital.extensions.components.MovementComponent

class MainScene : Scene() {
    private lateinit var player: GameObject
    private lateinit var pos: Vector2f
    private var redOrBlue: Boolean = true
    

    override fun init(game: Game?) {
        Log.info(javaClass, "Initialize main scene")
        pos = game!!.screenCenter

        player = GameObjectBuilder(this, "Player")
            .withTransform(game.screenCenter, Vector2f(20.0f, 20.0f))
            .withShape(Shapes.CIRCLE, Color.RED)
            .withComponents(MovementComponent(13.0f), ColorChanger())
            .build()

        addGameObject(game, player)
    }

    override fun update(game: Game?, fps: Float) {

    }

    override fun dispose(game: Game?) {
        Log.info(javaClass, "Dispose main scene")
    }
}