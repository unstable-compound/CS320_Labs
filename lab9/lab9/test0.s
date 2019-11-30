	.globl	Main_main
Main_main:
	pushl	%ebp
	movl	%esp,%ebp
	movl	$42,%eax
	pushl	%eax
	call	print
	movl	%ebp,%esp
	popl	%ebp
	ret
