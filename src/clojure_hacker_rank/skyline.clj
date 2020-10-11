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
  (let [new-heights (disj heights building)
        next-height (:height (first new-heights))]
    [new-heights
     (if (< next-height (:height (first heights)))
       (conj output [(:xf building) next-height])
       output)]))

(defn transform-to-events
  [building-array]
  (let [buildings (map #(apply ->Building %) building-array)]
    (into [] (sort-by
              (juxt :x #(let [h (:height (:building %))]
                          (if (= (:action %) up) (- h) h)))
              (concat (map #(->Event (:xi %) % up) buildings)
                      (map #(->Event (:xf %) % down) buildings))))))

(defn height-then-xf-then-xi
  [b1 b2]
  (let [c (compare (:height b2) (:height b1))]
    (if (not= c 0)
      c
      (let [c (compare (:xf b2) (:xf b1))]
        (if (not= c 0)
          c
          (let [c (compare (:xi b2) (:xi b1))]
            c))))))

(defn create-set
  [& keys]
  (apply sorted-set-by height-then-xf-then-xi (->Building nil nil 0) keys))

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
