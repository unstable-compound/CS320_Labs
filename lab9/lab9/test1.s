	.globl	Main_main
Main_main:
	pushl	%ebp
	movl	%esp,%ebp
	subl	$8,%esp
	movl	$0,%eax
	movl	%eax,-8(%ebp)
	movl	%eax,-4(%ebp)
	jmp	l1
l0:
	movl	$1,%eax
	movl	-4(%ebp),%ebx
	addl	%ebx,%eax
	movl	%eax,-4(%ebp)
	movl	-4(%ebp),%eax
	movl	-8(%ebp),%ebx
	addl	%ebx,%eax
	movl	%eax,-8(%ebp)
l1:
	movl	$10,%eax
	movl	-4(%ebp),%ebx
	cmpl	%eax,%ebx
	jl	l0
	movl	-8(%ebp),%eax
	pushl	%eax
	call	print
	movl	%ebp,%esp
	popl	%ebp
	ret
