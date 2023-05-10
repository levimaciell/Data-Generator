package org.levi.files;

import java.util.List;

public abstract class Generator<T> {

    public abstract List<T> generateData(int numberOfData);

}
