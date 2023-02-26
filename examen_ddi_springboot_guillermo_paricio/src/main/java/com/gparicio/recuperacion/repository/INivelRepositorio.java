package com.gparicio.recuperacion.repository;

import com.gparicio.recuperacion.model.Wordle;

public interface INivelRepositorio {
    void reset();

    Wordle getWordle();
}
