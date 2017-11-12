package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MyGdxGame extends ApplicationAdapter {

    private Stage stage;

    @Override
    public void create() {
        stage = new Stage(new FitViewport(640, 480));

        Group holder = new Group();
        holder.setSize(640, 480);
        holder.setTransform(false);
        holder.setTouchable(Touchable.childrenOnly);

        BitmapFont bitmapFont = new BitmapFont(Gdx.files.internal("font_16.fnt"));

        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font =bitmapFont;
        style.fontColor = Color.WHITE;
        style.cursor = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("cursor.png"))));

        TextField textField = new TextField(
                "Default Text",
                style);

        textField.setSize(320, textField.getHeight());
        textField.setAlignment(Align.center);
        textField.setPosition(holder.getWidth()/2f, holder.getHeight()/2f, Align.center);

        holder.addActor(textField);
        stage.addActor(holder);

        stage.setKeyboardFocus(textField);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

}
