package com.mlg.pong.controller.game.special;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.game.elements.*;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.model.menu.Menu;
import com.mlg.pong.states.MenuState;

import java.io.IOException;

public class SpecialGame1PController extends Controller<SpecialGame> {
    private final Player1Controller player1Controller;
    private final ComputerController player2Controller;
    private final BallController ballController;
    private final PowerUpController powerUpController;

    public Player1Controller getPlayer1Controller() {
        return player1Controller;
    }

    public ComputerController getPlayer2Controller() {
        return player2Controller;
    }

    public BallController getBallController() {
        return ballController;
    }

    public PowerUpController getPowerUpController() {
        return powerUpController;
    }

    public SpecialGame1PController(SpecialGame sgame) {
        super(sgame);
        this.player1Controller = new Player1Controller(sgame);
        this.ballController = new BallController(sgame);
        this.player2Controller = new ComputerController(sgame);
        this.powerUpController = new PowerUpController(sgame);
    }

    public void step(Application app, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel() == null)
            app.setState(new MenuState(new Menu()));
        else {
            player1Controller.step(app, action, time);
            ballController.step(app,action,time);
            player2Controller.step(app,action,time);
            powerUpController.step(app,action,time);
        }
    }
}
