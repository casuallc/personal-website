var PATH = "/blog0225";

function cprint(info) {
	console.log(info);
}

function isNull(obj) {
	return obj === undefined || obj === null;
}

function isEmpty(obj) {
	return isNull(obj) || obj === "";
}

function ifNull(obj, value) {
	return isNull(obj) ? (isNull(value) ? "" : value) : obj;
}

function ifEmpty(obj, value) {
	return isEmpty(obj) ? value : obj;
}