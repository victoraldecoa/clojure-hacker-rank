(ns clojure-hacker-rank.core
  (:gen-class)
  (:require [clojure-hacker-rank.rotate-left :refer [rotLeft]]
            [clojure-hacker-rank.hourglass :refer [hourglassSum]])
  )

(defn -main []
  (let [array [1 2 3] rotations 2]
    (println "Rotate Left of array" array "rotations" rotations "is"
             (rotLeft array rotations)))
  (let [input [[1 1 1] [1 1 1] [1 1 1]]] 
    (println "Hourglass sum of matrix" input "is"
             (hourglassSum input))))