const { log } = require('console');
const download = require('image-downloader');

// function downloadImage(urls, filepath) {
//     return download.image({
//        url:urls ,
//        dest: filepath 
//     });
// }


function myFunction() {
    // document.getElementById("demo").style.color = "red";
    // const prompt = require("prompt-sync")({ sigint: true });
    let link = `https://online.msbte.co.in/msbte22/index.php?act=cd_thumb_hall_ticket&rid=`
    let id = 4000970
    // let filepath   = `C:\\Users\\omshi\\Downloads\\img`
    for (id = 4000970; id < 4001000; id++) {
        let d = link + id
        window.open((link + id));
        // window.
        // let dd = link + id;
        // // downloadImage.image
        // download.image(downloadImage(dd, filepath))
        // .then(({filepath})) => {
        //     console.log();
        // }


        // console.log(link);
        // download.image({
        //     url : d,
        //     dest: filepath 
        //  });
    }
}


myFunction();

// let btnDownload = document.querySelector('button');
// let img = document.querySelector('img');


// // Must use FileSaver.js 2.0.2 because 2.0.3 has issues.
// btnDownload.addEventListener('click', () => {
//     let imagePath = img.getAttribute('src');
//     let fileName = getFileName(imagePath);
//     saveAs(imagePath, "fileName");
// });
