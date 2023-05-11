package org.levi.files;

import java.util.List;

public interface Generator<T> {

    List<T> generateData(int num);

    void outputInFile(String filename, List<T> elements);
}
