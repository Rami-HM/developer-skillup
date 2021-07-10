import React, { Component } from 'react'
import {AiOutlineFieldTime,AiOutlineCheck} from 'react-icons/ai';
import {RiDeleteBin2Line} from 'react-icons/ri';

export default class todoInfo extends Component {

    constructor(props){
        super(props);
        this.state = {
            id : '',
            name : '',
            regDate : '', 
            complete : '',
            changed: '', //수정이력
            isChange : false //수정중으로 이동
        };
    }

    //render > componentDidMount
    componentDidMount(){
    }

    setName = (e) =>{
        this.setState({name:e.target.value});
    }
    
    setIsChange = (obj) =>{
        this.setState({name:this.props.todoData.name,isChange:true});
    }

    updateTodoInfo = () =>{
        this.props.todoUpdate(
            {
                id : this.props.todoData.id,
                name : this.state.name,
            }
        );
        this.setState({changed:true,isChange:false});
    }

    deleteTodoInfo = () =>{
        if (window.confirm('삭제하시겠습니까?')) {
            this.props.todoDelete({id:this.props.todoData.id});
        }
    }

    completeTodoInfo = () =>{
        const complete = this.props.todoData.complete;
        this.props.todoComplete({
                id : this.props.todoData.id,
                complete : !complete
        });
    }

    render() {
        const {todoData} = this.props;
        return (
            <div className = "list_item"key={todoData.id} value = {'chkTodo' + todoData.id}>
                <span>
                    {this.state.isChange ? 
                      <div>
                        <input className = 'form-control wdth-75 hgt-20 mr-5' type ="text" value = {this.state.name || ''} onChange = {this.setName}></input>
                        <button className = 'wdth-20 hgt-25 cst-btn btn-blue' 
                                onClick = {this.updateTodoInfo}><AiOutlineCheck/></button>
                      </div>
                    :
                    <div className = {todoData.complete ? 'complete' : ''} >
                        <input className = 'mr-5' type = 'checkbox' checked = {todoData.complete} onChange = {this.completeTodoInfo}/> 
                        <span onDoubleClick = {this.setIsChange}>{todoData.name}</span>
                        <span onClick = {this.deleteTodoInfo}
                            className = "icon_delete"><RiDeleteBin2Line /></span>
                    </div>
                    }
                    <div className = "reg_time"><AiOutlineFieldTime />
                        {todoData.regDate}
                        {this.state.changed ? ' (수정됨)' : ''}
                    </div>
                </span>
               
            </div>
        )
    }
}
