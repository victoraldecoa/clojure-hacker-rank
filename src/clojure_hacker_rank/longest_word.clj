(ns clojure-hacker-rank.longest-word
  (:require
    [clojure.pprint :as pp]
    [clojure.string :as str]))

(def search-paths ["/Volumes/HD/Movies"
                   "/Volumes/HD/TV"])

(defn all-files-in-paths []
  (->> search-paths
       (map clojure.java.io/file)
       (mapcat file-seq)))

(defn subtitle? [file]
  (boolean (seq (re-seq #"\.srt$" file))))

(defn read-sub [path]
  (slurp
    path
    :encoding "ISO-8859-1"))

(defn read-all-subs []
  (->> (all-files-in-paths)
       (map #(.getPath %))
       (filter subtitle?)
       (map read-sub)))

(defn replace-diacritics [word]
  (-> word
      (str/replace #"[àáâã]" "a")
      (str/replace #"é" "e")
      (str/replace #"í" "i")
      (str/replace #"[óô]" "o")
      (str/replace #"[úü]" "u")))

(defn split-words [text]
  (-> (str/replace text #"[^a-z]+" " ")
      (str/split #"\s")
      set))

(defn with-frequencies [word]
  {:word        word
   :frequencies (frequencies word)})

(defn non-repeating-chars? [{:keys [frequencies]}]
  (let [count-seq (seq (vals frequencies))]
    (and count-seq
         (= (apply max count-seq) 1))))

(defn with-lengths [{:keys [word] :as e}]
  (assoc e :count (count word)))

(defn max-count [coll]
  (if (empty? coll)
    {:count 0}
    (apply max-key :count coll)))

(defn largest-non-repeating-word [dictionary]
  (->> dictionary
       (map with-frequencies)
       (filter non-repeating-chars?)
       (map with-lengths)
       max-count))

(defn without-frequencies [e]
  (dissoc e :frequencies))

(defn largest-non-repeating-word-in-file [file]
  (->> file
       str/lower-case
       replace-diacritics
       split-words
       largest-non-repeating-word
       without-frequencies))

(defn largest-non-repeating-word-in-the-world []
  (->> (read-all-subs)
       (map largest-non-repeating-word-in-file)
       set
       (sort-by :count)
       (take-last 20)))


(time
  (println
    (str "Searching through " (count (all-files-in-paths)) " subtitles...\n"
         "Results:\n"
         (with-out-str (pp/pprint (largest-non-repeating-word-in-the-world))))))