import { USER_NAME, mangSo } from './user.js'

import * as user from './user.js'

import Person from './user.js'

import { tong as sum } from './user.js'

console.log(USER_NAME)
console.log(mangSo)

console.log(user.USER_NAME)
console.log(user.mangSo)

sum(10, 5)

class Student extends Person {
    constructor(id, name, age) {
        super(id, name)
        this._age = age
    }
    info() {
        super.info()
        console.log(this._age)
    }
}

let student = new Student(1, 'A', 20)
student.info()