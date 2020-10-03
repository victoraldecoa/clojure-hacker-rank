(ns clojure-hacker-rank.skyline)

(defn up
  [building heights output]
  [(conj heights building)
   (if (< (last (last heights)) (last building))
     (conj output [(first building) (last building)])
     output)])

(defn down
  [building heights output]
  [(disj heights building)
   (if (< (last building) (last (last heights)))
     output
     (conj output [(building 1) (last (second (reverse heights)))]))])


(defn transform-to-events
  [buildings]
  (into []  (sort-by first (concat
                           (map (fn [b] [(b 0) b up  ]) buildings)
                           (map (fn [b] [(b 1) b down]) buildings)))))

(defn create-set
  [& keys]
  (apply sorted-set-by (fn [x y] (compare (last x) (last y))) [nil nil 0] keys))

(defn generate-skyline
  [buildings]
  (loop [heights (create-set)
         output []
         index 0
         events (transform-to-events buildings)]
    (if (>= index (count events)) output
        (let [event (events index)]
          (let [next ((last event) (second event) heights output)]
            (recur (first next) (second next) (inc index) events))))))
