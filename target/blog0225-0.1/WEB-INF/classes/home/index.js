$(function() {
	//drawTraingleMenu();
});

function drawTraingleMenu() {
	var mCanvas = document.getElementById("menu");
	var mContext = mCanvas.getContext("2d");
	
	mContext.strokeStyle = "#818181";
	
	var len = 50;
	var coord = [[100, 100]];
	var o = [200, 200];
	mContext.translate(o[0], o[1]);
	o[0] = 0;
	o[1] = 0;
	var x1 = [o[0], o[1]-len];
	var x2 = [o[0]+len*Math.sqrt(3)/2, o[1]+len/2];
	var x3 = [o[0]-len*Math.sqrt(3)/2, o[1]+len/2];
	
	mContext.font = "bold 15px verdana";
	mContext.textAlign = "center";
	mContext.rotate(Math.PI/3);
	mContext.fillText("menu1", 0, -(len-50)/2/2-50/2);
	
	mContext.rotate(2*Math.PI/3);
	mContext.fillText("menu2", 0, -(len-50)/2/2-50/2);
	
	mContext.rotate(2*Math.PI/3);
	mContext.fillText("menu3", 0, -(len-50)/2/2-50/2);
	
	mContext.rotate(Math.PI/3);
	mContext.globalCompositeOperation="destination-over";
	mContext.globalAlpha = 0.6;
	
	mContext.beginPath();
	mContext.fillStyle = "red";
	mContext.moveTo(x1[0], x1[1]);
	mContext.lineTo(x1_[0], x1_[1]);
	mContext.lineTo(x2_[0], x2_[1]);
	mContext.lineTo(x2[0], x2[1]);
	mContext.closePath();
	mContext.fill();
	
	mContext.beginPath();
	mContext.fillStyle = "yellow";
	mContext.moveTo(x2[0], x2[1]);
	mContext.lineTo(x2_[0], x2_[1]);
	mContext.lineTo(x3_[0], x3_[1]);
	mContext.lineTo(x3[0], x3[1]);
	mContext.closePath();
	mContext.fill();
	
	mContext.beginPath();
	mContext.fillStyle = "blue";
	mContext.moveTo(x3[0], x3[1]);
	mContext.lineTo(x3_[0], x3_[1]);
	mContext.lineTo(x1_[0], x1_[1]);
	mContext.lineTo(x1[0], x1[1]);
	mContext.closePath();
	mContext.fill();
	
	//smContext.restore();
}

function onMenuMouseOver() {
}

function getPoint(x1, x2, y1, y2, len) {
	var a = x2 - x1, 
	b = y2 - y1,
	c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	var x = a / c * len;
	var y = b / c * len;
	return [x, y];
}

function Point(x, y) {
	this.x = x;
	this.y = y;
}

function drawsss(center, len) {
	var mCanvas = document.getElementById("menu");
	var mContext = mCanvas.getContext("2d");
	mContext.strokeStyle = "#818181";
	
	// center 作为原点
	mContext.translate(center.x, center.y);
	var x1 = new Point(0, -len);
	var x2 = new Point(Math.sqrt(3)/2*len, len/2);
	var x3 = new Point(-Math.sqrt(3)/2*len, len/2);
	mContext.beginPath();
	mContext.moveTo(x1.x, x1.y);
	mContext.lineTo(x2.x, x2.y);
	mContext.lineTo(x3.x, x3.y);
	mContext.closePath();
	mContext.stroke();
	
	mContext.translate(-center.x, -center.y);
	return [new Point(x1.x+center.x, x1.y+center.y), new Point(x2.x+center.x, x2.y+center.y), new Point(x3.x+center.x, x3.y+center.y)];
}

function line(list1, list2) {
	var mContext = document.getElementById("menu").getContext("2d");
	mContext.strokeStyle = "#818181";
	mContext.beginPath();
	for(var i=0; i<list1.length; i++) {
		mContext.moveTo(list1[i].x, list1[i].y);
		mContext.lineTo(list2[i].x, list2[i].y);
		console.log(list2[i].x + " : " +  list2[i].y);
	}
	mContext.stroke();
}

function drawRegularPolygon(mContext, center, len, num) {
	if(num < 3 || len <= 0) {
		return;
	}
	mContext.translate(center.x, center.y);
	var array = new Array();
	var step = Math.PI*2 / num;
	// y轴负半轴夹角
	var curD = 0;
	for(var i=0; i<num; i++) {
		// 
		if(curD == 0) {
			array.push(new Point(0, -len));
		} else if(curD < Math.PI/2) {
			array.push(new Point(Math.sin(curD)*len, -Math.cos(curD)*len));
		} else if(curD == Math.PI/2) {
			array.push(new Point(len, 0));
		} else if(curD < Math.PI) {
			array.push(new Point(Math.sin(Math.PI-curD)*len, Math.cos(Math.PI-curD)*len));
		} else if(curD == Math.PI) {
			array.push(new Point(0, len));
		} else if(curD < Math.PI*3/2) {
			array.push(new Point(-Math.sin(curD-Math.PI)*len, Math.cos(curD-Math.PI)*len));
		} else if(curD == Math.PI*3/2) {
			array.push(new Point(-len, 0));
		} else if(curD < Math.PI*2) {
			array.push(new Point(-Math.sin(Math.PI*2-curD)*len, -Math.cos(Math.PI*2-curD)*len));
		} else if(curD = Math.PI*2) {
			array.push(new Point(0, -len));
		}
		curD += step;
	}
	
	mContext.beginPath();
	mContext.moveTo(array[0].x, array[0].y);
	for(var i=1; i<array.length; i++) {
		mContext.lineTo(array[i].x, array[i].y);
	}
	mContext.closePath();
	mContext.stroke();
	
	mContext.translate(-center.x, -center.y);
	for(var i=0; i<array.length; i++) {
		array[i].x += center.x;
		array[i].y += center.y;
	}
	return array;
}

$(function() {
	var center = new Point(200, 200);
	var len = 200;
	drawRegularPolygon(document.getElementById("menu").getContext("2d"), center, len, 15);
});