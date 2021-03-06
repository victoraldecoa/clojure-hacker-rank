(ns clojure-hacker-rank.core
  (:gen-class)
  (:require [clojure-hacker-rank.rotate-left :refer [rotate-left]]
            [clojure-hacker-rank.hourglass :refer [hourglass-sum]]
            [clojure-hacker-rank.skyline :refer [generate-skyline]]))

(defn n-from-arg
  [arg-n]
  (if (nil? arg-n)
    nil
    (if (integer? arg-n)
      arg-n
      (Integer/parseInt arg-n))))

(defn -main [& args]
  (let [array [1 2 3] rotations 2]
    (println "Rotate Left of array" array "rotations" rotations "is"
             (rotate-left array rotations)))
  (let [input [[1 1 1] [1 1 1] [1 1 1]]]
    (println "Hourglass sum of matrix" input "is"
             (hourglass-sum input)))
  (let [input [[3 4 10] [1 8 2]]]
    (println "Skyline for" input "is"
             (generate-skyline input)))
  ; profile huge skyline input
  (do (generate-skyline
       (let [n (or (n-from-arg (first args)) 5000)] (map (fn [i] [i (- n i) i]) (range 1 n)))) nil))
