(ns clojure-hacker-rank.rotate-left)

(defn rotLeft [a d]
  (concat (subvec a d) (subvec a 0 d)))

(defn rotLeftSlow [a d]
  (loop [i d
         b a]
    (println "looping " i " array " b)
    (if (= i 0)
      b
      (recur (dec i) (drop 1 (conj (vec b) (first b)))))))