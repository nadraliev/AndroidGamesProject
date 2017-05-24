package com.soutvoid.gamesproject.ui.screen.main.data

class ExploreSets(vararg objects: Any) {

    var data: List<ExploreSetData>? = null

    init {
        data = objects.map { it as ExploreSetData }.toList();
    }

    override fun toString(): String {
        return "com.soutvoid.gamesproject.ui.screen.main.data.ExploreSets(data=" + this.data + ")"
    }

    override fun equals(o: Any?): Boolean {
        if (o === this) return true
        if (o !is ExploreSets) return false
        val other = o
        if (!other.canEqual(this as Any)) return false
        val `this$data` = this.data
        val `other$data` = other.data
        if (if (`this$data` == null) `other$data` != null else `this$data` != `other$data`) return false
        return true
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$data` = this.data
        result = result * PRIME + (`$data`?.hashCode() ?: 43)
        return result
    }

    protected fun canEqual(other: Any): Boolean {
        return other is ExploreSets
    }
}
