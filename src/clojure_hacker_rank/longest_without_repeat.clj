(ns clojure-hacker-rank.longest-without-repeat)

(defn longest [input]
  (loop [window-start-prev 0
         window-end 0
         indexes {}
         max-length 0]
    (if (< window-end (count input))
      (let [cur-char (nth input window-end)
            window-start (max window-start-prev
                              (inc (get indexes cur-char -1)))]
        (recur
         window-start
         (inc window-end)
         (conj indexes {cur-char window-end})
         (max max-length (inc (- window-end window-start)))))
      max-length)))