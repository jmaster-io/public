export let USER_NAME = "javascript"

const numbers = [1, 3, 4]

function tong(x, y) {
    console.log(x + y)
}

export default class Person {
    constructor(id, name) {
        this._id = id
        this._name = name
    }
    info() {
        console.log(this._id + " - " + this._name)
    }
}
export { numbers as mangSo, tong }