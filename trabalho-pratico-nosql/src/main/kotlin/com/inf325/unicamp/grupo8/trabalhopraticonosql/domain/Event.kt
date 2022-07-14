package com.inf325.unicamp.grupo8.trabalhopraticonosql.domain

import org.springframework.data.mongodb.core.mapping.Document

@Document
class Event(id: String, name: String)
