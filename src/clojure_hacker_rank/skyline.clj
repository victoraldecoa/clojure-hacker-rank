(ns clojure-hacker-rank.skyline)

(defrecord Building [xi xf height])
(defrecord Event [x building action])

(defn up
  [building heights output]
  {:heights (conj heights building)
   :output (if (< (:height (first heights)) (:height building))
             (conj output [(:xi building) (:height building)])
             output)})

(defn down
  [building heights output]
  (let [new-heights (disj heights building)
        next-height (:height (first new-heights))]
    {:heights new-heights
     :output (if (< next-height (:height (first heights)))
               (conj output [(:xf building) next-height])
               output)}))

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
  (:output (reduce (fn [{output :output
                         heights :heights}
                        event]
                     ((:action event) (:building event) heights output))
                   {:output [] :heights (create-set)}
                   (transform-to-events buildings))))
