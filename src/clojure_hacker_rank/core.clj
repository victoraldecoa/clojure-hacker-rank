(ns clojure-hacker-rank.core
  (:gen-class)
  (:require [clojure-hacker-rank.rotate-left :refer [rotLeft]]
            [clojure-hacker-rank.hourglass :refer [hourglassSum]]
            [clojure-hacker-rank.skyline :refer [generate-skyline]])
  )

(defn -main []
  (let [array [1 2 3] rotations 2]
    (println "Rotate Left of array" array "rotations" rotations "is"
             (rotLeft array rotations)))
  (let [input [[1 1 1] [1 1 1] [1 1 1]]] 
    (println "Hourglass sum of matrix" input "is"
             (hourglassSum input)))
  (let [input [[3 4 10] [1 8 2]]]
    (println "Skyline for" input "is"
             (generate-skyline input))))
