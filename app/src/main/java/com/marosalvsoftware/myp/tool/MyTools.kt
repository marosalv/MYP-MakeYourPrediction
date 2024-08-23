package com.marosalvsoftware.myp.tool

import kotlin.random.Random

fun IntArray.myHeapSort(): IntArray {
    val arr = this
    val middle = arr.size / 2 - 1

    for (i in middle downTo 0)
        heapify(arr, arr.size, i)

    for (i in size - 1 downTo 0) {
        counter++
        arr[0] = arr[i].also { arr[i] = arr[0] }
        heapify(arr, i, 0)
    }
    return arr
}

var counter = 0
private fun heapify(arr: IntArray, size: Int, parent: Int) {

    println(arr.contentToString())
    var largest = parent
    val l = 2 * parent + 1
    val r = 2 * parent + 2

    if (l < size && arr[l] > arr[largest]) largest = l
    if (r < size && arr[r] > arr[largest]) largest = r

    if (largest != parent) {
        arr[parent] = arr[largest].also { arr[largest] = arr[parent] }
        heapify(arr, size, largest)
        counter++
        println("Changed $counter times")
    }
}


fun IntArray.mergeSort() :IntArray{

return 
}

private fun splitAndMerge(arr: IntArray) : IntArray{

val mid = arr.size -1 /2
var subLeft = arr.mySplitter(0, mid)
var subRight = are.mySplitter(mid+1,are.size - 1)

if(subLeft.size > 1)
subLeft = splitAndMerge(subLeft)

if(subRight.size > 1)
subRight = splitAndMerge(subRight)

return mergeArrange(subLeft, subRight)

}

private fun mergeArrange(left : IntArray, right :IntArray) : IntArray{
val result = IntArray(left.size + right.size)
var r = 0
var l = 0

for(i in result.indices){
if(l < left.size && r < right.size){
if(left[l] < right[r]){
result[i] = left[l++]
}else{
result[i] = right[r++]
}
}else if(l < left.size){
result[i] = left[l++]
}else{
result[i] = right[r++]
}
}

return result

}