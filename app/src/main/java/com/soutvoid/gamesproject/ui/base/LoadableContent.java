package com.soutvoid.gamesproject.ui.base;


/**
 * интерфейс для view, которые содержат загружаемый контент (в которых нужно отображать индикатор загрузки)
 */
public interface LoadableContent {

    void showTransparentPlaceholder();

    void hidePlaceholder();

    void showPlaceholderWithBackground();

}
