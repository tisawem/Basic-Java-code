import random


class java枚举常量合成类:

    def 获取选项数组(self):
        Temp = ""
        Arraylist = []
        while True:
            print("输入选项，输入2结束")
            selection = input()
            if selection == "2":
                if len(Arraylist) <= 1:
                    print("选项太少")
                    continue
                else:
                    return Arraylist
            else:
                Temp = f"\"{selection}\""
            print("选项是对是错，敲1是对，敲其他的算错")
            if input() == "1":
                Temp = f"{Temp},true"
            else:
                Temp = f"{Temp},false"
            Arraylist.append(Temp)

    def 获取题目(self):
        print("输入题目")
        return input()

    def 合成Java代码(self):
        java_code = ""
        for _ in range(0, 16):
            java_code += chr(random.randint(19968, 40959))
        java_code += "(\"" + self.获取题目() + "\",new LinkedHashMap<>() {{\n "
        for s in self.获取选项数组():
            java_code += "put(" + s + ");\n"
        return java_code + " } }),"


print(java枚举常量合成类().合成Java代码())
