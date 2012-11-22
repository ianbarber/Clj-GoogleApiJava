(ns clj-easygoog.core
	( :import
		[com.google.api.client.json JsonFactory]
		[com.google.api.client.json.jackson2 JacksonFactory]
		[com.google.api.client.http.javanet NetHttpTransport]
		[com.google.api.services.plus Plus PlusRequest PlusRequestInitializer Plus$Builder]
		))

;; Load in the https://developers.google.com/console vars
(load-file "config.clj")

;; Setup our calling objects
(def net-transport (NetHttpTransport.))
(def json-factory (JacksonFactory.))
(def json-init (PlusRequestInitializer. GOOGLE_API_KEY))
(def plus-builder (Plus$Builder. net-transport json-factory nil))
(def anon-plus (.build (.setPlusRequestInitializer plus-builder json-init)))

;; Query the API using the supplied key
(defn search [query]
	;; Perform a query
	(let [results (-> (.activities anon-plus) (.search query) (.execute))]
		;; Print out the results
		(map #(vector (.getTitle %1) (.getUrl %1)) (.getItems results))))



