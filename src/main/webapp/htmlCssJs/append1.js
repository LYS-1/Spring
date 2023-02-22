const list = document.getElementById('list');
const add = document.getElementById('add');

add.addEventListener('click', function(){
    //<li>d</li>
    //<li><button>click</button></li>
    let li = document.createElement('li');
    let li2 = document.createElement('li');
    let button = document.createElement('button');
    let text = document.createTextNode('d');
    let btext = document.createTextNode('click');
    let attr = document.createAttribute('class');
    attr.value='btn';
    attr.value = attr.value+' bg';
    button.setAttributeNode(attr);

    button.appendChild(btext);
    li.appendChild(text);
    li2.appendChild(button);
    //list.append(li);
    //list.append(li2);
    list.after(li2);
});