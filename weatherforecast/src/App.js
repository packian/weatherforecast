import React, { Component } from 'react';
import './App.css';
import Select from 'react-select';
import 'bootstrap/dist/css/bootstrap.min.css';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";



const locations = [
   { label: "Adelaide", value: "Adelaide" },
   { label: "Brisbane", value: "Brisbane" },
   { label: "Canberra", value: "Canberra" },
   { label: "Darwin", value: "Darwin" },
   { label: "Hobart", value: "Hobart" },
   { label: "Melbourne", value: "Melbourne" },
   { label: "Perth", value: "Perth" },
   { label: "Sydney", value: "Sydney" },
 ];

    class App extends Component {

      state = {
        forecastDat: [],
        header:[],
        startDate: new Date(),
        endDate: new Date(),
        selOpt:''
      }
      

      handleSDChange = date => {
         this.setState({
           startDate: date
         });
         let stateSelTmp = this.state.selOpt;
         if(stateSelTmp == ''){
            stateSelTmp = 'Adelaide'
         }
         let startDtTmp = date.toLocaleDateString();
         let startDtArr =  startDtTmp.split("/");
         let startDt = startDtArr[1] + '-' + startDtArr[0] + '-' + startDtArr[2]
          
          let endDtTmp = this.state.endDate.toLocaleDateString();
          let endDtArr = endDtTmp.split("/");
          let endDt = endDtArr[1] + '-' + endDtArr[0] + '-' + endDtArr[2]

      var header_sel = ['Date/Time(Zone-Australia/' + stateSelTmp + ')','Precipitation Probability (chance)','Temperature','Wind Speed','Wind Direction'];
      this.setState({ header: header_sel })

         fetch('http://localhost:8090/fetchWeatherForecast/' + stateSelTmp + '/' + startDt + '/' + endDt)
         .then(res => res.json())
         .then((data) => {
           this.setState({ forecastDat: data })
         })
         .catch(console.log)

       };

       handleEDChange = date => {
         this.setState({
            endDate: date
         });

         let stateSelTmp = this.state.selOpt;
         if(stateSelTmp == ''){
            stateSelTmp = 'Adelaide'
         }
         let startDtTmp = this.state.startDate.toLocaleDateString();
         let startDtArr =  startDtTmp.split("/");
         let startDt = startDtArr[1] + '-' + startDtArr[0] + '-' + startDtArr[2]
          
          let endDtTmp = date.toLocaleDateString();
          let endDtArr = endDtTmp.split("/");
          let endDt = endDtArr[1] + '-' + endDtArr[0] + '-' + endDtArr[2]

      var header_sel = ['Date/Time(Zone-Australia/' + stateSelTmp + ')','Precipitation Probability (chance)','Temperature','Wind Speed','Wind Direction'];
      this.setState({ header: header_sel })

         fetch('http://localhost:8090/fetchWeatherForecast/' + stateSelTmp + '/' + startDt + '/' + endDt)
         .then(res => res.json())
         .then((data) => {
           this.setState({ forecastDat: data })
         })
         .catch(console.log)

       };

      renderTableHeader() {
        return this.state.header.map((key, index) => {
           return <th key={index}>{key.toUpperCase()}</th>
        })
     }

      renderTableData() {
        return this.state.forecastDat.map((forecastRec, index) => {
           const { dateTimeUTC, precipitationChancePercent, temperatureCelsius, windSpeedKTS, windDirection } = forecastRec //destructuring
           return (
              <tr>
                 <td>{dateTimeUTC}</td>
                 <td>{precipitationChancePercent}</td>
                 <td>{temperatureCelsius} C</td>
                 <td>{windSpeedKTS} kts</td>
                 <td>{windDirection}</td>
              </tr>
           )
        })
     }

     handleChange = (selectedOption) => {

      var header_sel = ['Date/Time(Zone-Australia/' + selectedOption.value + ')','Precipitation Probability (chance)','Temperature','Wind Speed','Wind Direction'];
      this.setState({ header: header_sel })

      this.setState({ selOpt: selectedOption.value })

      let startDtTmp = this.state.startDate.toLocaleDateString();
      let startDtArr =  startDtTmp.split("/");
      let startDt = startDtArr[1] + '-' + startDtArr[0] + '-' + startDtArr[2]
       
       let endDtTmp = this.state.endDate.toLocaleDateString();
       let endDtArr = endDtTmp.split("/");
       let endDt = endDtArr[1] + '-' + endDtArr[0] + '-' + endDtArr[2]

      fetch('http://localhost:8090/fetchWeatherForecast/' + selectedOption.value + '/' + startDt + '/' + endDt)
      .then(res => res.json())
      .then((data) => {
        this.setState({ forecastDat: data })
      })
      .catch(console.log)

    }


      render() {
        
          return (
            <div>
            <h1 id='title'>Weather Forecast Data</h1>
            <div className="container">
            <div className="row">
               <div className="col-md-4"></div>
               <div className="col-md-4">
               Choose the location <Select onChange={this.handleChange} options={ locations } /><br></br>
               </div>
               <div className="col-md-4"></div>
            </div>
         </div>
         <div align="center">Start Date&nbsp; 
         <DatePicker id="startDt"
         dateFormat="dd-MM-yyyy"
         
               selected={this.state.startDate}
                onChange={this.handleSDChange}
         />
          &nbsp;           End Date&nbsp; 
         <DatePicker 
         dateFormat="dd-MM-yyyy"
               selected={this.state.endDate}
                onChange={this.handleEDChange}
         />
         </div>
         <br></br>
         <div>
            <table id='forecastGrid'>
               <tbody>
               <tr>{this.renderTableHeader()}</tr>
                  {this.renderTableData()}
               </tbody>
            </table>
         </div>
         

         </div>
          )
        }
      
       
      
    }

    export default App;