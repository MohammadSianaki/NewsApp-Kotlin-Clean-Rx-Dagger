package ir.siatech.newsappkotlinclean.domain.entities

enum class SourceEnum(val sourceName: String) {
    Bloomberg("bloomberg.com"),
    CNN("cnn.com"),
    Independent("indepenent"),
    Economist("economist.com"),
    TechCrunch("techcrunch.com"),
    WSJ("wjs.com")
}