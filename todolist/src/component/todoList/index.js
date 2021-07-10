import React, { Component } from 'react';
import TodoInfo from '../todoInfo';
import TodoForm from '../todoForm';

export default class todo extends Component {

  constructor(){
    super();
    this.state = {
      maxId : 0,
      inputTodoData : '',
      dataList : []
    }
  }

  //입력값 
  setInputToData = (e) =>{
    this.setState({inputTodoData : e.target.value});
  }

  //할일 목록 추가
  addTodoData = (e) =>{
    const inputData = this.state.inputTodoData;
    const tmpdataList = this.state.dataList;
    const maxId = this.state.maxId;
    
    if(!inputData) // 값이 들어오지 않을 경우
      return;

    tmpdataList.push({'id':maxId,'name':inputData, 'regDate':new Date().toLocaleString(), 'complete':false});
    this.setState({dataList:tmpdataList, inputTodoData:'', maxId:maxId+1});
  }

  todoListUpdate = (todoUpdateInfo) =>{

    todoUpdateInfo.regDate = new Date().toLocaleString();
    todoUpdateInfo.complete = false;

    const tmpTodoList = this.state.dataList;

    this.setState({
      dataList : tmpTodoList.map(item=>
        (item.id === todoUpdateInfo.id) ? 
          todoUpdateInfo : item
      )
    });
  }

  todoListDelete = (todoDeleteInfo) =>{
    const tmpTodoList = this.state.dataList;

    this.setState({
      dataList : 
      tmpTodoList.filter(item => item.id !== todoDeleteInfo.id)// id가 같지않은 값만 필터링
    });
  }

  todoListComplete = (todoCompleteInfo) =>{
    const tmpTodoList = this.state.dataList;

    this.setState({
      dataList : tmpTodoList.map(item=>
        (item.id === todoCompleteInfo.id) ? 
          {...item, complete:todoCompleteInfo.complete} : item
      )
    });
  }

  componentDidUpdate(){
  }

  render() {
    return (
        <div className = 'App'>
            <div className = 'contents'>
              <div className = 'title'>To-do List</div>
              <TodoForm todoData = {{'inputTodoData' : this.state.inputTodoData}}
                todoInputChange = {this.setInputToData}
                todoInputAdd = {this.addTodoData}
              />
              <div className = 'todo_list'>
                  {this.state.dataList.map((item,idx)=>{
                    return (<TodoInfo todoData = {{
                        'id' : item.id,
                        'name' : item.name,
                        'regDate' : item.regDate,
                        'complete': item.complete
                    }}
                    todoUpdate = {this.todoListUpdate}
                    todoDelete = {this.todoListDelete}
                    todoComplete = {this.todoListComplete}
                    test = {this.setInputToData}
                    key = {item.id}
                    />);
                  })}
              </div>
      
            </div>
          </div>
        )
    }
}
