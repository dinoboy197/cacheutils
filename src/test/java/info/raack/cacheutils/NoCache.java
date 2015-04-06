/**
 * This file is part of CacheUtils.
 *
 * (C) Copyright 2015 Taylor Raack.
 *
 * CacheUtils is free software: you can redistribute it and/or modify
 * it under the terms of the Affero GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CacheUtils is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Affero GNU General Public License for more details.
 *
 * You should have received a copy of the Affero GNU General Public License
 * along with CacheUtils.  If not, see <http://www.gnu.org/licenses/>.
 */

package info.raack.cacheutils;

public class NoCache<K, V> implements Cache<K, V> {

    private final BlockingFunction<K, V> cacheLoader;

    public NoCache(BlockingFunction<K, V> cacheLoader) {
        this.cacheLoader = cacheLoader;
    }

    @Override
    public V get(K key) throws InterruptedException {
        return cacheLoader.apply(key);
    }
}
