(ns clojure-hacker-rank.skyline)

(defrecord Building [xi xf height])
(defrecord Event [x building action])

(defn up
  [building heights output]
  [(conj heights building)
   (if (< (:height (first heights)) (:height building))
     (conj output [(:xi building) (:height building)])
     output)])

(defn down
  [building heights output]
  (let [new-heights (disj heights building)]
    [new-heights
     (if (< (:height building) (:height (first heights)))
       output
       (conj output [(:xf building) (:height (first new-heights))]))]))

(defn transform-to-events
  [building-array]
  (let [buildings (map #(apply ->Building %) building-array)]
    (into [] (sort-by first (concat
                             (map #(->Event (:xi %) % up) buildings)
                             (map #(->Event (:xf %) % down) buildings))))))

(defn create-set
  [& keys]
  (apply sorted-set-by #(compare (:height %2) (:height %1)) (->Building nil nil 0) keys))

(defn generate-skyline
  [buildings]
  (loop [heights (create-set)
         output []
         index 0
         events (transform-to-events buildings)]
    (if (>= index (count events)) output
        (let [event (events index)]
          (let [next ((:action event) (:building event) heights output)]
            (recur (first next) (second next) (inc index) events))))))
