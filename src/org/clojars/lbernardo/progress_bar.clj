(ns org.clojars.lbernardo.progress-bar)

(defn progress-bar [total]
  "Create a new progress bar"
  (atom {:progress 0
         :total    total
         :done?    false}))

(defn done [bar]
  "Change progress bar is done"
  (swap! bar assoc :done? true))

(defn is-done? [bar]
  "Progress bar is done?"
  (:done? @bar))

(defn- render [bar progress]
  "Render draw progress bar"
  (when (not (is-done? bar))
    (do
      (print (str (char 27) "[2J"))
      (let [total (:total @bar)
            percent (float (/ (* progress 100) total))
            line (int (/ (* progress 50) total))
            scape (- 50 line)]
        (print (str progress "/" total " "))
        (print "[")
        (dotimes [_ line] (print "="))
        (print ">")
        (dotimes [_ scape] (print " "))
        (print "]")
        (println (str "  [" (format "%.2f" percent) "%]"))))))

(defn increment
  "Increment in progress bar
  Use:
  (increment [bar])
  (increment [bar progress-now])
  Example:
  ; Create bar with let
  (pb/increment bar) ;{:progress 10, :total 100, :done? false}
  (pb/increment bar 10) ;{:progress 20, :total 100, :done? false} "
  ([bar progress]
   (let [progress-before (:progress @bar)
         progress-after (+ progress-before progress)
         total (:total @bar)]
     (swap! bar assoc :progress progress-after)
     (render bar progress-after)
     (when (= progress-after total) (done bar))))
  ([bar] (increment bar 1)))