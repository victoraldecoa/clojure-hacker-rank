(ns clojure-hacker-rank.hourglass)

(defn hourglass-sum [arr]
  (let
   [min-value Integer/MIN_VALUE]
    (->> (map-indexed
          (fn [i line]
            (map-indexed
             (fn [j elem]
               (+
                (nth (nth arr (dec i) []) (dec j) min-value)
                (nth (nth arr (dec i) []) j min-value)
                (nth (nth arr (dec i) []) (inc j) min-value)
                elem
                (nth (nth arr (inc i) []) (dec j) min-value)
                (nth (nth arr (inc i) []) j min-value)
                (nth (nth arr (inc i) []) (inc j) min-value))) line)) arr)
         (apply concat)
         (reduce max))))
