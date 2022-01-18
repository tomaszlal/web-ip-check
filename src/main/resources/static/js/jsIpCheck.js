let IpValid = false;

function validateIp() {
  validIp();
  document.getElementById("send-button").disabled = !IpValid;
//   console.log("ip "+IpValid);
  
}

function validIp() {
//   console.log("validujem");
  let fieldIp = document.getElementById("id-form");
  let ip = fieldIp.value;
  ip = ip.replace(/,/g, ".");
  ip = ip.replace(/[^0-9\\.]+/g, "");
//   console.log(ip);
  fieldIp.value = ip;
  let tableOfIp = ip.split(".");
//   console.log(tableOfIp.length);
  IpValid = true;
  if (tableOfIp.length == 4) {
    tableOfIp.forEach((el) => {
    //   console.log("el"+el)  
      if (el.length > 0) {
        let numb = parseInt(el);
        // console.log("numb: " + numb);

        if (numb < 0 || numb > 255 ) {
          IpValid = false;
        }
      } else {
          IpValid = false;
      }
    });
   
  } else {
    IpValid = false;
  }
}
