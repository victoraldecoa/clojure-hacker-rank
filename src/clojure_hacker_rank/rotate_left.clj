(ns clojure-hacker-rank.rotate-left)

(defn rotate-left [a d]
  (concat (subvec a d) (subvec a 0 d)))
