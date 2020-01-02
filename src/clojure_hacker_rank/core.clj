(ns clojure-hacker-rank.core
  (:gen-class)
  (:require [clojure-hacker-rank.rotate-left :refer [rotLeft]]))

(defn -main []
  (let [array [1 2 3] rotations 2]
    (println "Rotate Left of array" array "rotations" rotations "is"
             (rotLeft array rotations))))