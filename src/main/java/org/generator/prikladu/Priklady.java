package org.generator.prikladu;

import java.util.ArrayList;
import java.util.List;

public class Priklady {
    private final List<Priklad> priklady = new ArrayList<>();

    public void pridatPriklad(Priklad x) {
        priklady.add(x);
    }

    public List<Priklad> getPriklady() {
        return priklady;
    }
}
