(ns clojure-hacker-rank.rotate-left)

(defn rotate-left [a d]
  (concat (subvec a d) (subvec a 0 d)))

(defn slow-rotate-left [a d]
  (loop [i d
         b a]
    (println "looping " i " array " b)
    (if (= i 0)
      b
      (recur (dec i) (drop 1 (conj (vec b) (first b)))))))
