import React, { Component } from 'react'

export default class todoForm extends Component {


    render() {
        const {todoData, todoInputChange, todoInputAdd} = this.props;
        return (
            <div className = 'todo_formText'>
            <input className = 'hgt-25 wdth-75 form-control mr-5' type ="text" value = {todoData.inputTodoData} onChange = {todoInputChange}></input>
            <button className = 'wdth-20 hgt-30 cst-btn btn-dakGray' onClick = {todoInputAdd}>+</button>
          </div>
        )
    }
}
