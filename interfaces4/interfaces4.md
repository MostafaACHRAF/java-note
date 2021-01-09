## Interfaces

- If you change method's type from static to default, the code using this method won't compile.<br/>
- I you change method's type from static to abstract, all implementing classes might not compile.<br/>

- If you change method's type from abstract to default, the implementing classes will compile successfully.<br/>
- If you change method's type from abstract to static, the code using this method won't compile if the reference variable used to call this method is of type 'interface'.<br/>

- If you change method's type from default to abstract, the implementing classes will compile if they override the default method, otherwise, they won't compile.<br/>
- If you change method's type from default to static, the code that calls this method won't compile only if the reference variable used to call this method is of type 'interface'.<br/>

