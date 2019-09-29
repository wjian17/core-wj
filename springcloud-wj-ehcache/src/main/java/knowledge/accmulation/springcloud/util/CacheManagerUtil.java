package knowledge.accmulation.springcloud.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheManagerUtil {

    private static CacheManager cacheManager = CacheManager.create();

    private static final String ALBUM_SEARCH = "album_search";

    public static Object get(Object key) {
        Cache cache = cacheManager.getCache(ALBUM_SEARCH);
        if(cache!= null) {
            Element element = cache.get(key);
            if(element != null) {
                return element.getObjectValue();
            }
        }
        return null;
    }

    public static void put(Object key, Object value) {
        Cache cache = cacheManager.getCache(ALBUM_SEARCH);
        if (cache != null) {
            cache.put(new Element(key, value));
        }
    }

    public static boolean remove(Object key) {
        Cache cache = cacheManager.getCache(ALBUM_SEARCH);
        if (cache != null) {
            return cache.remove(key);
        }
        return false;
    }

}
