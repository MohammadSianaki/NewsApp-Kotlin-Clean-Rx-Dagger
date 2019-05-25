package ir.siatech.newsappkotlinclean.domain.entities

enum class SourceEnum(val sourceName: String) {
    Bloomberg("bloomberg"),
    CNN("cnn"),
    Independent("indepenent"),
    Economist("the-economist"),
    TechCrunch("techcrunch"),
    WSJ("the-wall-street-journal")
}