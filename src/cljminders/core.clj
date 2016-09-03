(ns cljminders.core
  (:require [cljminders.ui.ui :as ui])
  (:gen-class))

(defn -main
	"Print intro screen, starting point of execution"
  	[& args]
  	(println "\nWelcome to cljminders!")
  	(ui/prompt)
)
