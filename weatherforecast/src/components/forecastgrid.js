import React from 'react'

    const Contacts = ({ contacts }) => {
      return (

        <div className='col-lg-4' key={contact.dateTimeUTC}>
        {contact.locationType} - {contact.locationCode}
      </div>
      
      )
    };

    export default Contacts