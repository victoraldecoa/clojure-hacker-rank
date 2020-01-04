(ns clojure-hacker-rank.hourglass)

(defn hourglassSum [arr]
  (let
   [minValue Integer/MIN_VALUE]
    (->> (map-indexed
          (fn [i line]
            (map-indexed
             (fn [j elem]
               (+
                (nth (nth arr (dec i) []) (dec j) minValue)
                (nth (nth arr (dec i) []) j minValue)
                (nth (nth arr (dec i) []) (inc j) minValue)
                elem
                (nth (nth arr (inc i) []) (dec j) minValue)
                (nth (nth arr (inc i) []) j minValue)
                (nth (nth arr (inc i) []) (inc j) minValue))) line)) arr)
         (apply concat)
         (reduce max))))