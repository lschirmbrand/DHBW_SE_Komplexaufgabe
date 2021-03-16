package packageSortingCenter.sortingSystem.sortingTracks;

import configuration.Configuration;
import configuration.SearchAlgorithm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class SearchAlgorithmFactory {
    public static Object build(SearchAlgorithm algorithm) {
        Object algorithmPort = null;

        String archivePath = switch (algorithm) {
            case BOYER_MOORE -> Configuration.instance.pathToBoyerMooreArchive;
            case RABIN_KARP -> Configuration.instance.pathToRabinKarpArchive;
        };

        String className = switch (algorithm) {
            case BOYER_MOORE -> "BoyerMoore";
            case RABIN_KARP -> "RobinKarp";
        };

        try {
            URL[] urls = {new File(archivePath).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, SearchAlgorithm.class.getClassLoader());
            Class algorithmClass = Class.forName(className, true, urlClassLoader);
            Object algorithmInstance = algorithmClass.getMethod("getInstance").invoke(null);
            algorithmPort = algorithmClass.getDeclaredField("port").get(algorithmInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return algorithmPort;
    }
}
